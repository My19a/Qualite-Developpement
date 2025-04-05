# Qualité de développement

Le but de ce cours est de faire des tests d'intégration au fur et à mesure que des nouveaux composants sont intégrés dans une apllication 
tout en vérifiant que les tests précédents continuent de passer sans relever d'erreur. 
On appelle cela des tests de non regression.

Un projet vous est fourni. Il contient du code Java. A vous d'écrire les programmes de tesd.

## Support de cours

https://drive.google.com/drive/folders/1RVLc4yg5IKTq3OSht6wm1Cdjq9jOLEqy?usp=sharing

# Appropriation du projet

Vous devez vous appropier ce projet, c'est-à-dire que vous devez;

- le déplacer vers un dépôt Git appartenant à vous ou votre binôme
- inviter votre binôme à collaborer au projet 

Pour cela commencer par cloner ce projet :
```
git clone https://github.com/charroux/testsLogiciel
```

Créez ensuite un projet vide dans un de vos compte Github et utiliser les instructions suivantes pour copier le projet vers votre comopte Github en indiquat le nom de votre repository dans l'instruction git remote.

```
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/charroux/test1.git
git push -u origin main
```

# Collaborer à un projet : le ccncept du pull request

Quand un développeur collabore à un projet il porocède de la façon suivante : 

- il récupère le projet sur sa machine (git clone)
- il créé une copie du projet afin de ne pas affecter le code qui est déjà en production (git branch et git checkout)
- il travail à débogeur le code ou à développer une nouvelle fonctionnalité (git add, git commit)
- il écrit aussl les programmes de tests qui valident son travail
- et enfin il envoie sa copie du code vers le serveur git (git push)

Le chef de projet peut alors déclencher un processus d'intégration continue (CI) en lançant les procédures de tests écrit oar le développeur :
 c'est le pull request. Un script va alors être déclanché sur un serveur de test. 
Si les tests du développeurs sont concluants, le chef de projet peut alors décider de fisionner la copie du développeur avec la version originale (git marge).
 Tous les développeurs doivent alors récupérer la mise à jour du code sur leur machine en faisant un git pull. 
Et c'est là qu'on comprend le terme pull request qui est finalament une demande de pull faite par un développeur au chez de projet quand il a finit son travail.

## Prmmier essai de pull request

### Launch a workflow when the code is updated

The script is there: https://github.com/charroux/st2scl/blob/main/.github/workflows/acttions.yml

Créer une nouvelle branche sur votre machine:
```
git branch newcarservice
```
Se déplacer vers la nouvelle branche:
```
git checkout newcarservice
```
Modifier puis mettre à jour avec un :
```
git commit -a -m "newcarservice"
```
Se remettre sur la brnache main:
```
git checkout main
```
Envoyer les changements vers GitHub :
```
git push -u origin newcarservice
```
A partir de là, vous jouez le rôle d'un chef de projet.

Créer un pull request chez Github en comparant la nouvelle branche avec la votre. 
C'est un ce moment là qu"un script d'intégration continue va se déclencher chez Github. 
Goithub trouve le code de ce script dans votre projet : https://github.com/charroux/testsLogiciel/blob/main/.github/workflows/action.yml
Etudiez ce script et suivez son bon déreoulement chez Github. Si tout va bien, vous pourrez alors "merger" les branches chez Github.

NE PAS OUBLIER de faire alors un 
```
git pull origin main
```
Sur toutes les machines des développeurs (y-compris celle du développeur qui a soumis son code) afin de mettre à jour la branche main sinon le serveur Github n'acceptera pas de nouveau push au pretexte que le code n'est pas à jour.


Le code de ce script est dans 
Create a Pull request on GitHub and follow the workflow.

Merge the branch on Github is everything is OK.

Then pull the new main version:

```
git checkout main
```
```
git pull origin main
```
La nouvelle branche peut alors être effacée sur la machine du développeur est chez Github :

```
git branch -D newcarservice
```
```
git push origin --delete newcarservice
```


# TD 1 - JUnit

JUnit est un framework de test unitaire pour le langage de programmation Java, créé par Kent Beck et Erich Gamma.

Etudier un exemple de classe de Test : https://junit.org/junit5/docs/current/user-guide/#writing-tests

Etudier l'utilisation des assertions : https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

# TP 1 - JUnit

Créer un projet avec Intellij :

<img src="images/projet.png" width="500"/>

Attendre que le projet soit créé.

Ajouter la librairie Jupiter (clic droit sur le projet -> Open Module Settings) : 

<img src="images/librairie.png" width="500"/>

Ajouter dans src deux dossiers (java pour les classes à tester et test pour les classes de test).

Indiquer à Intellij que java est le dossier pour le code source et test celui pour les tests.

<img src="images/dossier.png" width="500"/>

Créer une classe Voiture dans le packe de src/main/Java.

Ajoutez à cette classe les attributs :
- une marque
- un prix

Créer une classe VoitureTest dans le package de src/test/Java et écrivez à la norme JUnit le code de test de la classe Voiture.

Lancer le programme de test (clic droit sur la classe de test).

## Sauvegarde de votre projet dans un dépôt Git vous appartenant

Créer un projet dans votre compte Github.

Poussez votre code vers votre dépôt git (en indiquant l'adresse de votre projet)

<img src="images/pushExistingProjet.png" width="500"/>

Indiquez l'adresse de votre projet dans le fichier dépots git : https://drive.google.com/drive/folders/1RVLc4yg5IKTq3OSht6wm1Cdjq9jOLEqy?usp=sharing

## Codage d'une classe de service

Coder une classe de service à partir l'interface (implanter l'interface: https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/service/Statistique.java

Ecrivez la classe de test.

# TP2

Etudiez la technique de la matrice de test dans le cours sur les tests : https://drive.google.com/drive/folders/1RVLc4yg5IKTq3OSht6wm1Cdjq9jOLEqy?usp=sharing

Etablir la matrice de tests.

Ajouter à votre projet les tests définis dans la matrice de tests.















# TD 2 - Spring boot test et Mockito

Etude du framework de test inclus dans les projets Spring boot : https://github.com/charroux/springbootest

Etude du framework de test Mockito: https://github.com/charroux/mockito

# TP 2

## Présentation de l'application

L'application à développer contient : 

- une base de données.
- un service Web

L'application est programmée en Java avec le framework Spring Boot (pour faciliter l'accès à la base de données ainsi 
que le développement du service web).

Le but de l'application est de faire des statistiques sur des voitures.

## Récupération du projet

L'application dont vous lisez le Readme actuellement ne vous appartient pas (vous n'êtes pas les proprétaires du dépôt git).
Cependant, vous pouvez télécharger ce projet sur vos machines et ensuite l'uploader vers un de vos dépôts git.

Voici une vidéo de démonstration qui est suivie de la procéédure détaillée commande par commande : https://e.pcloud.link/publink/show?code=XZ3qthZaMGfUQCtTUR1zXO0O5jqnQVf5lQX

Si vous n'avez pas utilisé Github depuis un moment, il se peut que le Token qui vous permet d'accéder à Github soit périmé.
Dans ce cas, il faudra en génbérer un autre. La procédure est indiqué ici : https://docs.github.com/en/enterprise-server@3.4/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token
Il faudra alors utiliser ce token à la place de votre mot de passe quand vous ferrez des commandes git.

Démarrer le machine de l'école sous Linux.

Attention ! sur les machines de l'IUT il faut se placer sur /tmp car cela ne fonctionne pas sur les dossiers personnels.
```
git clone https://github.com/charroux/qualiteDeDeveloppement
```
Se placer ensuite dans le dossier du projet:
```
cd qualiteDeDeveloppement
```
## Copie du projet dans un dépôt git qui vous appartient

Durant les TP vous allez travailler en binôme. Créez un dépôt de code public mais vide dans Github (sans Readme, ni gitignore),
puis recopier ce projet dans votre dépôt git en prodédant comme suit :
```
rm -rf .git
git init
git add *
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/[adresse .git de votre projet]
git push -u origin main
```

## Edition du projet

### Avec Intellij
Lancer Intellij et ouvrir tout simplement le projet. 
Cependant, sur les machines de l'IUT, la compilation du projet ne fonctionnera pas. 
Ce n'est pas très génant pour compiler votre projet vous pourrez ke faire via une commande.

### La phase de build incluant l'exécution des tests
Le build du projet (se compilation) ainsi que le lancement des programmes de tests peuvent se faire en ligne de commend via  la commande: 
```
./gradlew build
```
Une vidéo de démonstration : https://e.pcloud.link/publink/show?code=XZIwqhZkSSA8vXtyWmbn0aEKkgsrJ5QBxlX

Le consultation du rapport de test ce fait ici : build/reports/tests/test/index.html

### Avec Eclipse 
La version Eclipse de l'IUT n'ayant pas le plugin gradle, il n'est pas recommandé ee l'utiliser.

## Codage des classes de données, accès à la base de données

### Codage d'une classe Voiture

Une ébauche de la classe Voiture est donnée : https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/data/Voiture.java

Elle contient déjà un identifiant qui va servir de clef primaire à une table dans la base de données (explications à venir).

Ajoutez à cette classe les attributs :
 - une marque
 - un prix
 
### Tests unitaires de la classe Voiture
Le dossier src/test/java contient déjà l'ébauche de la classe de test de la voiture. 
Cette classe de test est appelée VoitureTest. Ajoutez à cette classe autant de méthodes que vous jugez utile pour 
tester la classe Voiture. Vérifiez que les méthodes de la classe Voiture retournent les résultats attendus en utilisant la classe Assert du framework Spring dont voici la documentation :

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/Assert.html

Sous Linux :
```
./gradlew build
```
Vérifier le rapport de test: build/reports/tests/test/index.html

# TP 3

## La base de données
La base de données est HSQLDB. Elle s'exécute "En mémoire" pour ne pas avoir à démarrer un serveur de base de données tant qu'on est en mode développement.
En conséquence, les données sont perdues dès que l'application s'arrête.

## Cours sur l'accès à la une base de données en Java
https://drive.google.com/drive/folders/1RVLc4yg5IKTq3OSht6wm1Cdjq9jOLEqy?usp=sharing

## Accès à la base de données
Pour permettre d'accéder par programmation à la base de données uns interface a déjà été programmée : https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/data/VoitureRepository.java

Un exemple d'utilisation de cette interface est données dans le cours sur l'accès à la base de données. 

Pour connaître l'ensemble des méthodes d'accès à la base de données, 
étudier l'interface CRUD repository : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

## Test de l'accès à la base de données
Les tests à réaliser ici vont utiliser le framework de test Mockito : https://github.com/charroux/mockito

Le dossier src/test/java (package data) contient l'ébauche du programme de test de la base de données :
https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/test/java/com/example/demo/data/BaseDeDonneesTests.java

Ajoutez à cette classe autant de méthodes que vous jugez utile pour tester l'accès à la base de données. 

# TP 4 : codage de la classe de service qui intègre la base de données

L'application a développer sur la base des voitures calcule des statistiques sur les voitures.
La base de cette application est une interface : https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/service/Statistique.java

## Coder une classe de service

Coder une classe qui implémente cette interface.
La classe Echantillon doit retourner le nombre de voiture et leur prix moyen.

Pour que cette classe puisse accéder à la base de données il suffit d'y ajouter :

```
@Autowired
VoitureRepository voitureRepository;
```

## Tests de la classe de service

Créer un package appelé service pour tester la classe de service et implementez-y un programme de test.

# TP 5 : codage de l'interface Web

## Cours sur les Web services Rest
https://drive.google.com/drive/folders/1RVLc4yg5IKTq3OSht6wm1Cdjq9jOLEqy?usp=sharing

## Codage d'un Web service

Ajouter au dossier src un package appelé web.

Coder une classe controller qui réagit à deux requêtes HTTP : 
- GET sur /statistique et qui retourne un objet du type échantillon
- POST qui permet d'ajouter une nouvelle voiture

## Test du Web service

Créer dans le dossier test un package web. Implentez-y une classe de test pour le Web service.

