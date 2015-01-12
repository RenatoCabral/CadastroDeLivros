package cadastrodelivros;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //private Object con;
    
    
    //funções de controle
    public void open(){//classe de abertura
        
        try{
            Class.forName("org.gjt.mm.mysql.Driver");//driver que inicia o mysql
            con = DriverManager.getConnection(url, user, password);//variavel con recebe as demais variaveis como parametro
            stat = con.createStatement(); 
        }catch(ClassNotFoundException ex){//Se não tiver conecxao mostra a mensagem abaixo
            System.out.println(ex.getMessage());
        
        }catch(SQLException ex){//Se não tiver conecxao mostra a mensagem abaixo
            System.out.println(ex.getMessage());
        }
        System.out.println("Executado com sucesso");   
    }
    
    public void close(){//classe de fechamento
        
        try{
            stat.close();
            con.close();
            
        }catch (SQLException ex){//algum erro exibe a mensagem do driver necessario
            System.out.println(ex.getMessage());  
        }
        System.out.println("Fechado");   
    
    }
    
    public void execute(String query){//classe de execução
        
        try{
            if(stat.executeUpdate(query) != Statement.EXECUTE_FAILED){//vai atualizar os dados no banco
            
                System.out.println("Registro gravado com sucesso");
        }
        
        
        }catch(SQLException ex){//algum erro exibe a mensagem do driver necessario
            System.out.println(ex.getMessage()); 
        }
    
    
    }
    
    //variaveis de armazenamento
    private final String url="jdbc:mysql://localhost:3306/Livro";
    private final String user="root";
    private final String password="123";
    
    Connection con;
    Statement stat;
}
