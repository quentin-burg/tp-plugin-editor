Project Plugin
============

Auteurs
-------

Alexia OMIETANSKI

Alan MENIT

Quentin BURG


Introduction
------------

Dans ce projet, il était question de produire une petite application qui génère un
questionnaire à partir d'un fichier texte formaté correctement (une ligne pour la question,
une ligne pour la réponse et une ligne pour le nombre de points gagnés).
Nous devions dans un premier temps réaliser l'implémentation de ce questionnaire 
puis réaliser une interface graphique.


Remarques
----------

Dans ce projet nous avons utilisé plusieurs design pattern, singleton, factory, template method.

Nous n'avons pas totalement terminé la partie graphique :    les réponses de l'utilisateur ne sont pas
prises en compte, nous obtenons donc un pointeur null. De même, nous n'avons pas géré le fait
de pouvoir changer de langue dans les réponses.



HOWTO
-----

Pour récupérer le projet du dépôt :  
  * **git@gitlab-etu.fil.univ-lille1.fr:omietanski/PluginProject.git**
    

Pour compiler le projet et les tests puis les exéctuer et créer l'archive jar :  
   * **mvn package**


Pour exécuter l'archive jar (depuis le répertoire projectpool) :  
  * **java -jar target/PluginProject-1.0-SNAPSHOT.jar**


Pour générer la documentation :  
   * **mvn javadoc:javadoc**

Lien vers les diagrammes UML
----------------------------


Fichier ucls :    
* <https://gitlab-etu.fil.univ-lille1.fr/burg/surveyProject/blob/master/pluginUML.ucls>

Diagramme UML : 
* ![Diagramme UML](https://gitlab-etu.fil.univ-lille1.fr/burg/surveyProject/blob/master/pluginUML.png)

