//package repas.dto;
//
//
//public class ConnexionDTO {
//	private String login;
//	private String password;
//
//	public ConnexionDTO() {
//		super();
//	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//}
package repas.dto;

public class ConnexionDTO {
    private String login;
    private String password;
    private String role; // Champ pour spécifier le rôle de l'utilisateur lors de la connexion ("utilisateur" ou "admin")

    // Constructeurs, getters et setters
    public ConnexionDTO() {}

    public ConnexionDTO(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

