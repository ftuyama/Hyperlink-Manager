package GUI;
import java.util.Calendar;
import java.util.ArrayList;

public class Hyperlink {
    public Calendar data;
    private String name, url;
    private ArrayList<String> metatags = new ArrayList<>();
    private ArrayList<String> comentarios = new ArrayList<>();
    
    Hyperlink(){ }
    Hyperlink (String name, String Url){
        data = Calendar.getInstance();
        this.name = name;
        this.url = Url;
    }
    // ---------------------------------//--------------------------------------
    // ######################### Funções sobre a Url: ##########################
    public void setUrl (String url){
        data = Calendar.getInstance();
        this.url = url;
    }
    public String getUrl (){
        return url;
    }
    // ---------------------------------//--------------------------------------
    // ##################### Funções sobre o Nome: #############################
    public void setName (String name){
        data = Calendar.getInstance();
        this.name = name;
    }
    public String getName (){
        return name;
    }
    // ---------------------------------//--------------------------------------
    // ##################### Funções sobre a Data: #############################
    String NewDate;
    int i;
    public int GetValue(char parada) {
        String aux = "";
        for (i++; NewDate.charAt(i) != parada; i++)
            aux += NewDate.charAt(i);
        return Integer.parseInt(aux);
    }
    public void setDate(String InputDate) {
        NewDate = InputDate;
        int year, month, date, hourOfDay, minute;
        
        for (i = 0; NewDate.charAt(i)!=':'; i++); i++;
        hourOfDay = GetValue(':');
        minute = GetValue(' ');
        date = GetValue('/');
        month = GetValue('/');
        year = Integer.parseInt(NewDate.substring(i+1));
        data.set(year, month, date, hourOfDay, minute);
    }
    public String getDate() {
        String aux = "";
        aux += data.get(Calendar.HOUR_OF_DAY) + ":";
        aux += data.get(Calendar.MINUTE) + " ";
        aux += data.get(Calendar.DAY_OF_MONTH) + "/";
        aux += data.get(Calendar.MONTH) + "/";
        aux += data.get(Calendar.YEAR);
        return aux;
    }
    public boolean containDate(String Date){
        boolean igualdade = false;
        String Dia, Mes, Ano;
        Dia = Date.substring(0, 2);
        Mes = Date.substring(3, 5);
        Ano = Date.substring(6, 10);
        if(data.get(Calendar.DAY_OF_MONTH)==Integer.parseInt(Dia))
            if (data.get(Calendar.MONTH)==Integer.parseInt(Mes))
                if (data.get(Calendar.YEAR)==Integer.parseInt(Ano))
                    igualdade = true;
        return igualdade;
    }
    // ---------------------------------//--------------------------------------
    // ##################### Funções sobre a MetaTag: ##########################
    public void addMetaTag (String MetaTag){
        data = Calendar.getInstance();
        metatags.add(MetaTag);
    }
    public void editMetaTag (String oldMetaTag, String newMetaTag){
        data = Calendar.getInstance();
        metatags.remove(oldMetaTag);
        metatags.add(newMetaTag);
    }
    public void removeMetatag(String oldMetatag) {
        data = Calendar.getInstance();    
        metatags.remove(oldMetatag);
    }
    public boolean containMetaTag (String MetaTag){
        return (metatags.contains(MetaTag));
    }
    public String printMetaTag (){
        String MetaList = "";
        if (!metatags.isEmpty()){
            for(String Meta : metatags) 
                MetaList  += Meta+",";
            MetaList  = MetaList.substring(0, MetaList.length()-1);
        }
        return MetaList ;
    }
    // ---------------------------------//--------------------------------------
    // ################### Funções sobre o Comentário: ########################
    public void addComment (String Comment){
        data = Calendar.getInstance();
        comentarios.add(Comment);
    }
    public void editComment(String oldComment, String newComment){
        data = Calendar.getInstance();
        removeComment(oldComment);
	addComment(newComment);
    }
    public void removeComment(String oldComment) {
        data = Calendar.getInstance();
        comentarios.remove(oldComment);
    }
    public boolean containComment (String Comment){
        return (comentarios.contains(Comment));
    }
    public String printComment (){
        String Comment = "";
        if (!comentarios.isEmpty()){
            for(String Come : comentarios) 
                Comment  += "\n \""+Come+"\"";
        }
        Comment +="\n"+" ";
        return Comment ;
    }
    // ---------------------------------//--------------------------------------
}