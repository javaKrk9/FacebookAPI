import java.util.*;
import java.util.stream.Collectors;

public class FacebookApp implements FacebookService
{

    private List<Facebook> listOfUsers;

    public FacebookApp(List<Facebook> listOfUsers)
    {
        this.listOfUsers = listOfUsers;
    }

    @Override
    public Facebook findById(String id) throws NotFoundException
    {
        if(listOfUsers.stream().filter(c->c.getId().equals(id)).collect(Collectors.toList()).isEmpty())
        {
            throw new NotFoundException("There is no profile with id='"+id+"'");
        }
        return listOfUsers.stream().filter(c->c.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @Override
    public Map<String, Long> findMostCommonWords()
    {
        Map<String, Long> commonWords = new HashMap<>();

        for(Facebook fb: listOfUsers)
        {
            for(Post post: fb.getPosts())
            {
                String[] messageWords = extractWordsToAnalysis(post.getMessage().toLowerCase());
                for(String word: messageWords)
                {
                    if(commonWords.containsKey(word))
                    {
                        Long wordCount = commonWords.get(word)+1;
                        commonWords.remove(word);
                        commonWords.put(word,wordCount);
                    }
                    else
                    {
                        commonWords.put(word,1l);
                    }
                }
            }
        }
        return commonWords;
    }

    protected String[] extractWordsToAnalysis(String text)
    {
        text = text.toLowerCase();
        text = extractPureWords(text);
        return removeEmpty(text.split(" "));
    }

    private String extractPureWords(String text)
    {
        text = text.replace(".", "").replace(",", "").replace(";", "").replace("!", "").replace("?", "").replace(")", "")
                .replace("(", "").replace(":", "").replace("\"", "").replace("-", "").replace("\n", " ");
        return text;
    }

    private String[] removeEmpty(String[] words)
    {
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        String[] returnArray = wordsList.stream().filter(a->!a.equals("")).toArray(String[]::new);
        return returnArray;
    }


    @Override
    public Set<String> findPostIdsByKeyword(String word)
    {
        Set<String> postsId = new TreeSet<>();

        for(Facebook fb: listOfUsers)
        {
            for(Post post: fb.getPosts())
            {
                if(post.getMessage().contains(word))
                {
                    postsId.add(post.getId());
                }
            }
        }
        return postsId;
    }

    @Override
    public Set<Facebook> findAll()
    {
        Set<Facebook> fbSet = new TreeSet<>();

        for(Facebook fb: listOfUsers)
        {
            fbSet.add(fb);
        }

        return fbSet;
    }
}
