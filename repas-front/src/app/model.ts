export class Utilisateur {
    public id?: number;
    public nom?: string;
    public prenom?: string;
    public login?: string;
    public password?: string;
    public disabled?: boolean;

    constructor(id?: number, nom?: string, prenom?: string,  login?: string, password?: string, disabled?: boolean) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom ;
        this.login = login;
        this.password = password;
        this.disabled = disabled;
    }
}

export class Administrateur {
    public id?: number;
    public nom?: string;
    public prenom?: string;
    public login?: string;
    public password?: string;
    public disabled?: boolean;

    constructor(id?: number, nom?: string, prenom?: string,  login?: string, password?: string, disabled?: boolean) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom ;
        this.login = login;
        this.password = password;
        this.disabled = disabled;
    }
}