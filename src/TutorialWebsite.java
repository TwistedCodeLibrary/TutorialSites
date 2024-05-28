/** TutorialWebsite.java

file for TutorialWebsite object

 */



public class TutorialWebsite
{ // begin TutorialWebsite class

    // declare object properties
    private String lang;
    private String description;
    private String url;

    // constructor methods -------------------------------------------

    TutorialWebsite(){
    } //end TutorialWebsite()

    TutorialWebsite(String lang, String description, String url)
    { // begin TutorialWebsite(lang, description, url)
        this.lang = lang;
        this.description = description;
        this.url = url;
    } // end TutorialWebsite(lang, description, url)

    // accessor methods -------------------------------------------

    public String getLang() {
        return lang;
    } // end getLang()

    public String getDescription() {
        return description;
    } // end getDescription()

    public String getUrl() {
        return url;
    } // end getUrl()

    //mutator methods -------------------------------------------

    public void setLang(String lang) {
        this.lang = lang;
    } // end setLang()

    public void setDescription(String description) {
        this.description = description;
    } // end setDescription(0

    public void setUrl(String url) {
        this.url = url;
    } // end setUrl()

    // method to return data from TutorialWebsite class to string

    public String toString()
    { // begin toString()
        return "Language: " + lang + '\n' +
                "Description: " + description + '\n' +
                "Url: " + url + '\n' + '\n';
    } // end toString()

    // method to compare TutorialWebsite object by language name

    public int compareTo(TutorialWebsite x)
    { // begin compareTo
       return lang.compareTo(x.lang);
    } // end compareTo()

} // end TutorialWebsite class


