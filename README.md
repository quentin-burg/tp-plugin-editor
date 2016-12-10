Project Plugin
============

Auteurs
-------

Alexia OMIETANSKI

Alan MENIT

Quentin BURG


Introduction
------------

Dans ce projet, il était question de mettre en place un petit éditeur de texte afin
de pouvoir ajouter des plugins (par exemple mettre le texte en majuscule) à celui-ci.   
Cela nous a permis de mettre en pratique le design pattern Observer.


Remarques
----------

Dans ce projet nous avons utilisé le design pattern Observer.

Nous avons un petit problème concernant les plugins. Si l'on veut mettre un texte en majuscule,
cela fonctionne mais si l'on veut le remettre en minuscule, il ne se passe rien.    
En ce qui concernent le menu Help, il affiche une popup avec le "helpMessage" du Plugin, mais il le fait
plusieurs fois.

En ce qui concerne les tests, ils fonctionnent sous Eclipse mais pas avec mvn package. On ne sait pas pourquoi.
C'est pourquoi on a mis le dossier target pour avoir le fichier .jar.

Alan n'a pas fait de commit parce que le VPN ne fonctionne pas de chez lui, mais nous avons travaillé en trinôme tout au long de ce projet.


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
* <https://gitlab-etu.fil.univ-lille1.fr/omietanski/PluginProject/blob/master/PluginProject/pluginUML.ucls>

Diagramme UML : 
* ![Diagramme UML](https://gitlab-etu.fil.univ-lille1.fr/omietanski/PluginProject/blob/master/PluginProject/pluginUML.png)

