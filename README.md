# Conduite de Projet : Enigma   
Travail à réaliser pour l'UE Conduite de Projet

_Assurez-vous d'avoir installé Java 21. Concretement le JDK pour lancer le code source._

### Pour lancer ce projet
- Utilisez un IDE tel que IntellIJ Idea ou Eclipse et exécutez la classe Main.java en l'ouvrant depuis le répertoire enigma.
Assurez-vous que le chemin d'accès (path) pour la valeur resourcepath dans Init.java est correct :  
```resourcepath = "resources/"```


### Une autre façon de lancer le projet est d'utiliser le script lanceJeu.sh.

- Modifiez le chemin d'accès (path) dans Init.java :  
`resourcepath = "../resources/"`  

- Utilisez ensuite le script lanceJeu.sh.


Sur le livrable un JAR est disponible pour lancer l'application.

### Description du jeu

À travers trois mini-jeux, on peut accumuler des indices qui vous seront utiles lors du dernier mini-jeu.  
_(En fonction des résultats (nombre nécessaire de bonnes réponses pour valider l'indice pour chaque jeu), on obtiendra un indice)._

**Jeu n°1 :** Un jeu de questions-réponses avec 10 questions sur la cryptographie ! Répondez rapidement, car le temps est limité. En fonction du nombre de réponses correctes (nombre nécessaire pour valider l'indice), vous obtiendrez votre premier indice !

**Jeu n°2 :** Un jeu sur les mots de passe, organisant une liste de 14 mots de passe selon leur niveau de sécurité (faible, moyen, fort).

**Jeu n°3 :** Un jeu de déchiffrage, décoder un message crypté en utilisant un tableau de correspondances entre les lettres codées et les originales.

**Jeu final - Enigma :** La on résout Enigma en trouvant le mot mystère a l'aide des indices récoltés.

**Pour réussir faut trouver le mot dans le temps imparti pour remporter la victoire.**