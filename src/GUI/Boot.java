/*package GUI;
import java.util.Scanner;

public class Boot 
{
    public void static main(String[] args) 
    {
        char C = '.';
        String aux1, aux2, aux3;
        Scanner entrada = new Scanner(System.in);
        ListaHyperlinks List = new ListaHyperlinks();
        boolean Quit = false;

        System.out.println("########################################");
        System.out.println("### Hyperlink Manager V 1.2 - Jarvis ###");
        System.out.println("########################################");
        // ---------------------------------//--------------------------------------
        // ############################# BEGIN LOOP #################################
        // ---------------------------------//--------------------------------------
        while (!Quit)
        {
            // ---------------------------------//--------------------------------------
            // ################################### MENU #################################
            // ---------------------------------//--------------------------------------
            System.out.println("---------------------------------------");
            System.out.println("| [Main Menu] Choose an option:       |");
            System.out.println("---------------------------------------");
            System.out.println("| (A)dd  | (E)dit | (R)emove | (V)iew |");
            System.out.println("| (L)oad | (S)ave |          | (Q)uit |");
            System.out.println("---------------------------------------");
            try{ C = Character.toUpperCase(entrada.nextLine().charAt(0));}
            catch (Exception erro){ System.err.println(erro.getMessage());}
            
             // ---------------------------------//--------------------------------------
            if (C == 'A') // ############################ Add ###########################
            {
                System.out.println("------------------------------------------");
                System.out.println("| [Add Menu] What will you Add?          |");
                System.out.println("------------------------------------------");
                System.out.println("| (U)rl | (M)etaTag | (C)omment | (Q)uit |");
                System.out.println("------------------------------------------");
                try{ C = Character.toUpperCase(entrada.nextLine().charAt(0));}
                catch (Exception erro){ System.err.println(erro.getMessage());}
                
                if (C == 'U'){
                    System.out.println("Type the new Url:");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the name of the new Url:");
                    aux2 = entrada.nextLine();
                    List.addUrl(aux1, aux2);
                }
                else if (C == 'M'){
                    System.out.println("Type the name of the Url:");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the new MetaTag to add:");
                    aux2 = entrada.nextLine();
                    List.addMetaTag(aux1,aux2);
                }
                else if (C == 'C'){
                    System.out.println("Type the name of the Url:");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the new Comment to add:");
                    aux2 = entrada.nextLine();
                    List.addComment(aux1,aux2);
                }
                else if (C == 'Q') Quit = true;
                else System.out.println("Unknown Command");
            }
             // ---------------------------------//--------------------------------------
            else if (C == 'E') // ############################ Edit #####################
            {
                System.out.println("--------------------------------------------------");
                System.out.println("| [Edit Menu] What will you Edit?                |");
                System.out.println("--------------------------------------------------");
                System.out.println("| (U)rl | (N)ame |(M)etaTag | (C)omment | (Q)uit |");
                System.out.println("--------------------------------------------------");
                try{ C = Character.toUpperCase(entrada.nextLine().charAt(0));}
                catch (Exception erro){ System.err.println(erro.getMessage());}
                
                if (C == 'U'){
                    System.out.println("Type the old Url: ");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the new Url: ");
                    aux2 = entrada.nextLine();
                    List.editUrl(aux1, aux2);
                }
                else if (C == 'N'){
                    System.out.println("Type the old name of the Url: ");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the new name of the Url: ");
                    aux2 = entrada.nextLine();
                    List.editName(aux1, aux2);
                }
                else if (C == 'M'){
                    System.out.println("Type the name of the Url: ");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the MetaTag to edit: ");
                    aux2 = entrada.nextLine();
                    System.out.println("Type the new MetaTag: ");
                    aux3 = entrada.nextLine();
                    List.editMetaTag(aux1, aux2, aux3);
                }
                else if (C == 'C'){
                    System.out.println("Type the name of the Url: ");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the Comment to edit: ");
                    aux2 = entrada.nextLine();
                    System.out.println("Type the new Comment: ");
                    aux3 = entrada.nextLine();
                    List.editComment(aux1, aux2, aux3);
                }
                else if (C == 'Q') Quit = true;
                else System.out.println("Unknown Command");
            }
             // ---------------------------------//--------------------------------------
            else if (C == 'R')  // ######################### Show #######################
            { 
                System.out.println("-----------------------------------------");
                System.out.println("| [Remove Menu] What will you Remove?   |");
                System.out.println("-----------------------------------------");
                System.out.println("| (U)rl |(M)etaTag | (C)omment | (Q)uit |");
                System.out.println("-----------------------------------------");
                try{ C = Character.toUpperCase(entrada.nextLine().charAt(0));}
                catch (Exception erro){ System.err.println(erro.getMessage());}
                
                if (C == 'U'){
                    System.out.println("Type the name of the Url: ");
                    aux1 = entrada.nextLine();
                    List.removeUrl(aux1);
                }
                else if (C == 'M'){
                    System.out.println("Type the name of the Url: ");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the name of the MetaTag to remove: ");
                    aux2 = entrada.nextLine();
                    List.removeMetaTag(aux1, aux2);
                }
                else if (C == 'C'){
                    System.out.println("Type the name of the Url: ");
                    aux1 = entrada.nextLine();
                    System.out.println("Type the Comment to remove: ");
                    aux2 = entrada.nextLine();
                    List.removeComment(aux1, aux2);
                }
                else if (C == 'Q') Quit = true;
                else System.out.println("Unknown Command");
            }
            // ---------------------------------//--------------------------------------
            else if (C == 'V')  // ######################### View ########################
            {  
                System.out.println("-----------------------------------------------");
                System.out.println("| [View Menu] How do you want to view?  (By)  |");
                System.out.println("-----------------------------------------------");
                System.out.println("|   (L)ist       |   (N)ame       | (D)ate    |");
                System.out.println("|   (M)etaTag    |   (C)omment    | (Q)uit    |");
                System.out.println("-----------------------------------------------");
                try{ C = Character.toUpperCase(entrada.nextLine().charAt(0));}
                catch (Exception erro){ System.err.println(erro.getMessage());}
                
                if (C == 'L')
                    List.printList();
                else if (C == 'N'){
                    System.out.println("Type the Name to view:");
                    List.printListByName(entrada.nextLine());
                }
                else if (C == 'D'){
                    System.out.println("Type the Date to view (format XX/XX/XX):");
                    List.printListByDate(entrada.nextLine());
                }
                else if (C == 'M'){
                    System.out.println("Type the MetaTag to view: ");
                    List.printListByMetaTag(entrada.nextLine());
                }
                else if (C == 'C'){
                    System.out.println("Type the Comment to view: ");
                    List.printListByComment(entrada.nextLine());
                }
                else if (C == 'Q') Quit = true;
                else System.out.println("Unknown Command");
            }
            // ---------------------------------//--------------------------------------
            else if (C == 'L') // ######################### Load #######################
            {
                System.out.println("Type the name of the File to load: ");
                List.LoadFile(entrada.nextLine());
            }
            // ---------------------------------//--------------------------------------
            else if (C == 'S') // ######################### Save #######################
            {
                System.out.println("Type the name of the File to save: ");
                List.SaveFile(entrada.nextLine());
            }
            // ---------------------------------//--------------------------------------
            else if (C == 'Q') Quit = true;
            else System.out.println("Unknown Command");
        }
        // ---------------------------------//--------------------------------------
        // ############################## END LOOP #################################
        // ---------------------------------//--------------------------------------
    }
}
*/ 