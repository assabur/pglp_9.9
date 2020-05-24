# pglp_9.9
# Logiciel de dessin en ligne de commande

Objectif du projet

Réaliser un logiciel de dessin qui permet de faire une description textuelle, de creer de deplacer des figures 	géométriques telles que: des carre, des rectangles, des cercles des triangles, mais aussi d'un groupe de figure.
	
	```Description des figures:
	Un carre est une figure géométrique ayant un point et un coté. Exemple: Carre(upLeft(1,0),cote=10)
	Un cercle est une figure géométrique ayant un centre et un rayon. Exemple: Cercle(centre=(0,0),rayon=10)
	Un rectangle est une figure géométrique ayant un point haut gauche(upLeft) et un point bas 	droit(downRight). 
	Exemple: Rectangle(upLeft(1,5),upRight(3,2))
	Un triangle est une figure géométrique ayant trois points et un rayon. Exemple:Triangle(point1(1,1),point2(3,4),point3(0,4))```

# Manuel utilisateur 
```Pour faciliter l'utilisation du logiciel l'utilisateur pourra voir l'ensemble des commandes à l'aide de la commande HELP. Ainsi on peut voir certaines commandes specifiques et d'autres generiques. 
	Creation:  
				 cerc= Cercle((centrX, centreY), rayon)
				 carr = Carre((xUpleft, yUpleft),cote)
				 rect = Rectangle((xUpleft, yUpleft),(xUpright, yUpright))
				 trig = Triangle((x, y), (x, y), (x, y))
				 composé = Compose(c1, c2, r1, t1)
	Déplacement: 		 move(c1,(x, y))
	Affichage:   		 show(r1)
	Quitter:     	         quit```
	
# Manuel Technique
```Pour persister les données nous utilisons Derby(SGBD embarquer).En effet on stocke chaque figure sous formes d'objet.Un objet etant une forme géometrique.
	Pour cloner le projet faire: git clone https://github.com/assabur/pglp_9.9
ensuite 
	mvn clean 
	mvn package
	java -jar target/pglp_9.9-1.0-SNAPSHOT.jar
	ou encore ouvrir le projet avec un IDE et executer DrawingApp.java ```
	
	
	
	
	
	
	
	
	
	
	
	
