# Application de Gestion Bancaire

## Description
Cette application de gestion bancaire est construite avec **Spring Boot** pour le backend et **Angular** pour le frontend. Elle permet de gérer des utilisateurs, des comptes, des transactions, et des contacts, tout en offrant des fonctionnalités d'authentification et d'autorisation.

## Table des Matières
- [Fonctionnalités](#fonctionnalités)
- [Technologies Utilisées](#technologies-utilisées)
- [Installation](#installation)
- [Configuration](#configuration)
- [Utilisation](#utilisation)
- [Documentation API](#documentation-api)
- [Exemples d'Interfaces](#exemples-dinterfaces)
- [Contributeurs](#contributeurs)
- [License](#license)

## Fonctionnalités
- Inscription et connexion des utilisateurs
- Gestion des rôles (Administrateur, Utilisateur)
- Création, modification et suppression de contacts
- Gestion des transactions (dépôts, retraits)
- Interface utilisateur réactive
- Sécurité avec JWT

## Technologies Utilisées
- **Backend**: Spring Boot, Java
- **Frontend**: Angular, TypeScript, HTML, CSS
- **Base de données**: PostgreSQL
- **Documentation API**: Swagger

## Installation
1. Clonez le repository:
   ```bash
   git clone https://github.com/username/nom-du-repo.git
   ```
2. Naviguez dans le dossier du projet :
   ```bash
   cd nom-du-repo
   ```

3. Installez les dépendances pour l'application Spring Boot :
   ```bash
   ./mvnw install
   ```

4. Installez les dépendances pour l'application Angular :
   ```bash
   cd frontend
   npm install
   ```

## Configuration
1. **Configurer la base de données PostgreSQL :**
  - Modifiez les propriétés dans le fichier `application.properties` ou `application.yml` pour indiquer les bonnes informations de connexion à votre base de données.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/votre-base-de-donnees
   spring.datasource.username=votre-utilisateur
   spring.datasource.password=votre-mot-de-passe
   ```

2. **Configurer JWT :**
  - Définissez les clés secrètes pour JWT dans votre fichier de configuration.

## Utilisation
1. **Démarrer le backend :**
   ```bash
   ./mvnw spring-boot:run
   ```

2. **Démarrer le frontend :**
   ```bash
   cd frontend
   ng serve
   ```

## Documentation API
La documentation Swagger de notre API :
![Documentation Swagger API 1](IMG/Swagger/img02.png)  
![Documentation Swagger API 2](IMG/Swagger/img03.png)  
![Documentation Swagger API 3](IMG/Swagger/img04.png)  
![Documentation Swagger API 4](IMG/Swagger/img05.png)  
![Documentation Swagger API 5](IMG/Swagger/img06.png)  
![Documentation Swagger API 6](IMG/Swagger/img07.png)  
![Documentation Swagger API 7](IMG/Swagger/img08.png)  
![Documentation Swagger API 8](IMG/Swagger/img09.png)

## Exemples d'Interfaces

### 1. Diagramme de Classe
Voici le diagramme de classe après l'implémentation de toutes les entités :
![Diagramme de Classe](IMG/img01.png)

### 2. Interface de Connexion et d'Inscription
Voici l'interface de connexion et d'inscription :
![Page de Connexion](IMG/img03.png)  
![Page d'Inscription](IMG/img02.png)

### 3. Service CommandLineRunner
J'ai implémenté un service **CommandLineRunner** qui permet de créer un utilisateur au démarrage de l'application avec le rôle : **ROLE_ADMIN**.
![CommandLineRunner Service](IMG/img04.png)

## Tester notre Application

### 5.1 Authentification avec l'administrateur
- **Essayer de se connecter avec l'utilisateur créé par notre service au démarrage de l'application. Un message indique que cet utilisateur ne peut pas se connecter car son compte n'est pas encore actif.**
  ![Essayer de connecter](IMG/img05.png)
  ![Essayer de connecter](IMG/img06.png)

- **Activation du compte utilisateur depuis notre base de données PostgreSQL**
  ![Activer compte](IMG/img07.png)

- **Connexion de l'utilisateur administrateur**
  ![Connter avec l'administrateur](IMG/img08.png)
  ![Connter avec l'administrateur](IMG/img09.png)

### 5.2 Créer un utilisateur avec rôle ADMIN & Activer son compte
- **Commencer par la création de l'utilisateur, remplir ses informations et lui affecter le rôle ADMIN comme montré ci-dessous**
  ![Création utilisateur](IMG/img10.png)
  ![Création utilisateur](IMG/img11.png)
  ![Création utilisateur](IMG/img12.png)
  ![Création utilisateur](IMG/img13.png)
  ![Création utilisateur](IMG/img14.png)

- **Activer son compte en cliquant sur le bouton checkbox radio**
  ![Activer compte utilisateur](IMG/img15.png)

### 5.3 Création de compte par l'utilisateur via la page d'inscription
- **Création du compte pour l'utilisateur depuis la page d'inscription**
  ![Niveau compte_register](IMG/img16.png)
- **Message confirmant que la création du compte a été reçue. L'administrateur doit d'abord valider et activer son compte.**
  ![Niveau compte_register](IMG/img17.png)
- **Liste des utilisateurs, incluant celui créé à partir de la page d'inscription**
  ![Niveau compte_register](IMG/img18.png)

### 5.4 Tentative de connexion avec l'utilisateur
- **Saisir les informations de l'utilisateur**
  ![Saisir ces informations](IMG/img19.png)
- **Message indiquant que cet utilisateur ne peut pas accéder car son compte n'est pas encore actif.**
  ![Compte-InActive](IMG/img20.png)
- **Confirmation que son compte n'est pas encore actif.**
  ![Compte-InActive](IMG/img21.png)
- **Activation du compte utilisateur par l'administrateur**
  ![Compte-Active](IMG/img22.png)
- **Connexion de l'utilisateur après l'activation de son compte par l'administrateur**
  ![Tenter de connecter](IMG/img23.png)
  ![Connecter au plateform par son compte est reçu](IMG/img24.png)

### 5.5 Gestion des Transactions
- **Liste des transactions**
  ![Liste de transactions](IMG/img25.png)
- **Création d'une transaction de type DÉPÔT**
  ![Creation_Niveau_Transaction](IMG/img26.png)
  ![Creation_Niveau_Transaaactional](IMG/img27.png)
- **Message confirmant que la transaction a bien été reçue**
  ![Message_Confirm_Transaction](IMG/img28.png)
- **Liste des transactions mises à jour**
  ![Liste de transactions](IMG/img29.png)

### 5.6 Gestion des Contacts
- **Liste des contacts**
  ![Liste de contacts](IMG/img30.png)
- **Création d'un contact**
  ![Creation_Niveau_Contact](IMG/img31.png)
- **Message confirmant que le contact a bien été reçu**
  ![Message_Confirm_Contact](IMG/img32.png)
- **Liste des contacts mise à jour**
  ![Liste de contacts](IMG/img33.png)
- **Modification d'un contact par ID**
  ![Modfier_contact_par_id](IMG/img34.png)
  ![Modfier_contact_par_id](IMG/img35.png)
  ![Modfier_contact_par_id](IMG/img36.png)
  ![Modfier_contact_par_id](IMG/img37.png)
  ![Modfier_contact_par_id](IMG/img38.png)
- **Suppression d'un contact par ID**
  ![Supprimer_contact_par_id](IMG/img39.png)
  ![Supprimer_contact_par_id](IMG/img40.png)
  ![Supprimer_contact_par_id](IMG/img41.png)

### 5.7 Déconnexion
- **Déconnexion de l'utilisateur**
  ![Déconnexion](IMG/img42.png)
- **Confirmation de la déconnexion**
  ![Déconnexion](IMG/img43.png)
  ![Déconnexion](IMG/img44.png)

## Sécurité avec les Gardes
- **La sécurité est gérée via des gardes pour assurer une protection adéquate des ressources de l'application.**

## Contributeurs
- [Votre Nom](https://github.com/votrecompte)
- [Collaborateurs](https://github.com/)

## License
Ce projet est sous licence MIT. Consultez le fichier [LICENSE](LICENSE) pour plus de détails.

---

Merci pour votre attention et votre soutien !
