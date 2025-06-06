import java.util.*;
public class Sample {

    // Popularity Tracker Atlassian Coding interview Question.
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        PopularityTracker popularityTracker = new PopularityTracker();

        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.increasePopularity(8);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());       // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns -1 since there is no content with popularity greater than 0

    }

}
class PopularityTracker{
    HashMap<Integer, Integer> contentToPopularity;
    TreeMap<Integer, HashSet<Integer>> popularityToContent;
    public PopularityTracker()
    {
        contentToPopularity = new HashMap<>();
        popularityToContent = new TreeMap<>();
    }
    // for now increase quantum is always 1.
    void increasePopularity(Integer contentId)
    {
        Integer oldPopularity = contentToPopularity.getOrDefault(contentId,0);

        Integer newPopularity = oldPopularity+1;
        // increased in content to popularity
        contentToPopularity.put(contentId,newPopularity);

        if(oldPopularity!=0)
        {
        // remove the old popularity bucket for content id
        popularityToContent.get(oldPopularity).remove(contentId);
        // remove bucket if set is zero size
        if(popularityToContent.get(oldPopularity).size()==0)
            popularityToContent.remove(oldPopularity);
        }
        
        // add into the new popularity bucket for content id.
        if(popularityToContent.containsKey(newPopularity))
        {
            popularityToContent.get(newPopularity).add(contentId);
        }
        else{
            HashSet<Integer> hs = new HashSet<>();
            hs.add(contentId);
            popularityToContent.put(newPopularity,hs);
        }
        //popularityToContent.computeIfAbsent(newPopularity, new HashSet<Integer>()).add(contentId);
        
    }
    void decreasePopularity(Integer contentId)
    {
        Integer oldPopularity = contentToPopularity.getOrDefault(contentId,-1);
        if(oldPopularity !=-1)
        {
            Integer newPopularity = oldPopularity-1;
            // decrease popularity/ remove if zero  in content to popularity
            if(newPopularity ==0)
                contentToPopularity.remove(contentId);
            else
                contentToPopularity.put(contentId, newPopularity);

            // remove the old popularity bucket for content id
            popularityToContent.get(oldPopularity).remove(contentId);
            
            // remove bucket if set is zero size
            if(popularityToContent.get(oldPopularity).size()==0)
                popularityToContent.remove(oldPopularity);

            // add into the new popularity bucket for content id if non-zero popularity.
            if(newPopularity>0)
            {
                if(popularityToContent.containsKey(newPopularity))
                {
                    popularityToContent.get(newPopularity).add(contentId);
                }
                else{
                    HashSet<Integer> hs = new HashSet<>();
                    hs.add(contentId);
                    popularityToContent.put(newPopularity,hs);
                }
            }
                //popularityToContent.computeIfAbsent(newPopularity, new HashSet<Integer>()).add(contentId);


        }
    }
    Integer mostPopular()
    {
        if(popularityToContent.size()>0)
        {   
            System.out.println(popularityToContent);
            // retrieve the most popular one from popularity to count map
            return popularityToContent.lastEntry().getValue().iterator().next();
        }

        // default
        return -1;
    }
}

/*
 * maintain map of content -> popularCount and popularCount -> Set(Contents)
 * arrange them as stream of actions come in.
 * return popularCounts first content in set for mostpopular.
 */

/*
 * Assumptions: first assume contents to be fit in memory to start with
 * popularity to be bound within integer limits to start with
 * if two contents have same popularity , return any one to start with.
 */
/*
 * content id - ations : inc popularity by +1, dec popularity by -1
 * content id are positive integers
 * class to return most popular content id any time while consume stream of actions.
 * if no content id with popularity > 0 return -1;
 * 
 * 
 * interface MostPopular {
    void increasePopularity(Integer contentId);
    Integer mostPopular();
    void decreasePopularity(Integer contentId);
}
Sample execution: 
[
  popularityTracker.increasePopularity(7);
  popularityTracker.increasePopularity(7);
  popularityTracker.increasePopularity(8);
  popularityTracker.mostPopular();        // returns 7
  popularityTracker.increasePopularity(8);
  popularityTracker.increasePopularity(8);
  popularityTracker.mostPopular();        // returns 8
  popularityTracker.decreasePopularity(8);
  popularityTracker.decreasePopularity(8);
  popularityTracker.mostPopular();        // returns 7
  popularityTracker.decreasePopularity(7);
  popularityTracker.decreasePopularity(7);
  popularityTracker.decreasePopularity(8);
  popularityTracker.mostPopular();        // returns -1 since there is no content with popularity greater than 0
]
 */