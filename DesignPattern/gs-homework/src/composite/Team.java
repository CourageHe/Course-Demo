package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CourageHe
 * @Date 2022/3/27 19:47
 */
public class Team implements ITeam{
    public String teamName;
    List<ITeam> persons = new ArrayList<>();

    public Team() {
        this.teamName = "unKnown";

    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void Add(ITeam t){
        persons.add(t);
    }
    public void Remove(ITeam t){
        persons.remove(t);
    }

    @Override
    public void Show() {
        System.out.println("Team Name is "+this.teamName);
        for(ITeam person : persons){
            person.Show();
        }

    }
}
