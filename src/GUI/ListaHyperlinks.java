package GUI;
import java.util.ArrayList;

public class ListaHyperlinks 
{
    Arquivo File = new Arquivo();
    ArrayList<Hyperlink> Urls = new ArrayList<>();
    // ---------------------------------//--------------------------------------
    // ######################## Funções sobre a Url: ###########################
    public void addUrl(String URL, String name){
        Hyperlink newUrl = new Hyperlink(name, URL);
        Urls.add(newUrl);
    }
    public void editUrl(String oldUrl, String newUrl){
        for (Hyperlink Url : Urls)
            if (Url.getUrl().equals(oldUrl))
                Url.setUrl(newUrl);
    }
    public void editName(String oldName, String newName){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(oldName))
                Url.setName(newName);
    }
    public void removeUrl(String name){
        Hyperlink aux = new Hyperlink("","");
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                aux = Url;
        if (aux.getName().equals(name))
            Urls.remove(aux);
    }
    // ---------------------------------//--------------------------------------
    // ###################### Funções sobre a MetaTag: #########################
    public void addMetaTag(String name, String MetaTag){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                Url.addMetaTag(MetaTag);
    }
    public void editMetaTag(String name, String oldMeta, String newMeta){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                Url.editMetaTag(oldMeta, newMeta);
    }
    public void removeMetaTag(String name, String Meta){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                Url.removeMetatag(Meta);
    }
    // ---------------------------------//--------------------------------------
    // ################## Funções sobre o Comentário: ##########################
    public void addComment(String name, String Comment){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                Url.addComment(Comment);
    }
    public void editComment(String name, String oldComment, String newComment){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                Url.editComment(oldComment, newComment);
    }
    public void removeComment(String name, String Comment){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(name))
                Url.removeComment(Comment);
    }
    // ---------------------------------//--------------------------------------
    // ###################### Funções sobre a Impressão ########################
    public String printUrl(Hyperlink Url){
        String retorno = "";
        
        retorno+="--------------------------------------\n";
        retorno+="[Url #" + (Urls.indexOf(Url) + 1) + "]: "+ Url.getName()+"\n";
        retorno+=" "+Url.getUrl()+"\n";
        retorno+=" MetaTags: {" + Url.printMetaTag() + "}\n";
        retorno+=" Comments: " + Url.printComment()+"\n";
        retorno+=" Última Modificação: " + Url.getDate()+"\n";
        retorno+="---------------------------------------\n";
        return retorno;
    }
    public String printList() {
        String retorno = "";
        retorno+="\n############## Url List ##############\n";
        for (Hyperlink Url : Urls)
            retorno+=printUrl(Url);
        if (Urls.isEmpty())
            retorno += "Empty List!\n";
        retorno+="######################################\n";
        return retorno;
    }
    public String printListByName(String Name){
        String retorno ="";
        boolean empty = true;
        retorno+="\n####### Url List Name:{"+Name+"}######\n";
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(Name)){
                retorno += printUrl(Url);
                empty = false;
            }
        if (empty) retorno+="Empty List!\n";
        retorno+="######################################\n\n";
        return retorno;
    }
    public String printListByMetaTag(String MetaTag){
        String retorno = "";
        boolean empty = true;
        retorno+="\n#### Url List MetaTag:{"+MetaTag+"}###\n";
        for (Hyperlink Url : Urls)
            if (Url.containMetaTag(MetaTag)){
                retorno += printUrl(Url);
                empty = false;
            }
        if (empty) retorno+="Empty List!\n";
        retorno+="######################################\n";
        return retorno;
    }
    public String printListByComment(String Comment){
        String retorno = "";
        boolean empty = true;
        retorno+="\n#### Url List Comment:{"+Comment+"}###\n";
        for (Hyperlink Url : Urls)
            if (Url.containComment(Comment)){
                retorno += printUrl(Url);
                empty = false;
            }
        if (empty) retorno+="Empty List!\n";
        retorno+="######################################\n\n";
        return retorno;
    }
    public String printListByDate(String Date){
        String retorno = "";
        boolean empty = true;
        retorno+="\n##### Url List Date:{"+Date+"}#####\n";
        for (Hyperlink Url : Urls)
            if(Url.containDate(Date)){
                retorno += printUrl(Url);
                empty = false;
            }
        if (empty) retorno+="Empty List!\n";
        retorno+="######################################\n\n";
        return retorno;
    }
    // ---------------------------------//--------------------------------------
    // ################### Funções sobre o Load Arquivo #########################
    private void LoadMetaTags(String Metas, String UrlName){
        int i;
        String MetaTag;
        for (i =0; Metas.charAt(i)!='{'; i++);
        while (Metas.charAt(i)!='}'){
            for (i++, MetaTag = ""; Metas.charAt(i)!=','&& Metas.charAt(i)!='}'; i++)
                MetaTag += Metas.charAt(i);
            addMetaTag(UrlName, MetaTag);
        }
    }
    private void LoadComments(String Commen, String UrlName){
        String Comment = Commen.substring(2, Commen.length()-1);
        addComment(UrlName, Comment);
    }
    public void LoadDate (String NewDate, String Name){
        for (Hyperlink Url : Urls)
            if (Url.getName().equals(Name))
                Url.setDate(NewDate);
    }
    public void LoadFile(String Name){
        String Url = "", UrlName = "";
        File.openRead(Name);
        while (File.isReadable()){
            while(!File.read().contains("Url #") && File.isReadable());
            if (File.isReadable()){
                
                Url = File.read();
                UrlName = File.read();
                addUrl(Url, UrlName);
                LoadMetaTags(File.read(), UrlName);
                File.read();
                for (String aux = File.read(); !(aux.equals(" ")); aux = File.read())
                    LoadComments(aux, UrlName);
                LoadDate(File.read(), UrlName);
            }
        }
        File.closeRead();
    }
    // ---------------------------------//--------------------------------------
    // ################### Funções sobre o save Arquivo ########################
    public void writeUrl(Hyperlink Url){
        File.write("--------------------------------------");
        File.write("[Url #" + (Urls.indexOf(Url) + 1) + "]: ");
        File.write(Url.getUrl());
        File.write(Url.getName());   
        File.write("MetaTags: {" + Url.printMetaTag() + "}"+"");
        File.write("Comments: " + Url.printComment());
        File.write("Última Modificação: " + Url.getDate()+"");
        File.write("---------------------------------------");
    }
    public void SaveFile(String Name){
        File.openWrite(Name);
        File.write("########################################");
        File.write("### Hyperlink Manager V 1.2 - Jarvis ###");
        File.write("########################################");
        File.write("############## Url List ##############");
        for (Hyperlink Url : Urls)
            writeUrl(Url);
        if (Urls.isEmpty())
            File.write("Empty List!");
        File.write("######################################");
        File.closeWrite();
    }
    // ---------------------------------//--------------------------------------
}