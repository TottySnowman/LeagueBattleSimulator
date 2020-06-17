package Data;

public class Champion
{
    private String name;
    private String title;
    private String icon;
    private Stats stats;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Stats getStats()
    {
        return stats;
    }

    public void setStats(Stats stats)
    {
        this.stats = stats;
    }
}
