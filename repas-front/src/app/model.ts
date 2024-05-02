export class Compte {
    public id?: number;
    public nom?: string;
    public prenom?: string;
    public email?: string;
    public password?: string;
    public type_compte?:string;

    constructor(id?: number, nom?: string, prenom?: string,  email?: string, password?: string, type_compte?:string) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom ;
        this.email = email;
        this.password = password;
        this.type_compte = type_compte;
    }
}

export class Utilisateur extends Compte{
    

    constructor(id?: number, nom?: string, prenom?: string,  email?: string, password?: string, type_compte?:string) {
        super(id, nom, prenom, email, password, type_compte);
    }
}


export class Administrateur extends Compte{
   
    constructor(id?: number, nom?: string, prenom?: string,  email?: string, password?: string, type_compte?:string) {
        super(id, nom, prenom, email, password, type_compte);
    }
    
}