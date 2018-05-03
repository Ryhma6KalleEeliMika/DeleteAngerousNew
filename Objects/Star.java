package Objects;


import javafx.scene.image.Image;
import Main.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalle
 */
public class Star {
    
    //Star's id (not used as for know).
    private int id;
    
    //Star's name.
    private String name;
    
    //Star's Surface
    private Surface starsSurface;
    
    //Is star scoopable
    private boolean scoop;
    
    //Scoop attempts times
    private int scoopTimes = 0;

    //Star's neighbours names.
    private String n1, n2, n3, n4;

    //Star's neighbours.
    private Star star1, star2, star3, star4;
    
    //Star system images and the galaxy map image
    private Image starImage, starImage1, starImage2, starImage3, starImage4, galaxyMapImage;
    
    //Star's child planets.
    private Planet planet1, planet2, planet3, planet4;
    
    //Is star scanned
    private boolean scanned;
    
    //image paths
    private final String STARIMGPATH = "Images/Stars/";
    
    private final String GMAPIMGPATH = "Images/GalaxyMap/";
    
    //Star's default constructor creates the star's image object.
    public Star(int starId, String starName, boolean scoopable) {
        main.starMap.put(starName, false);
        main.systemMap.put(starName, false);
        this.id = starId;
        this.name = starName;
        this.scoop = scoopable;
        if (scoopable){
            this.scoopTimes = 2;
        }
        Surface starsSurface = new Surface(starName);
        setStarsSurface(starsSurface);
        
        
        //Setting up images for stars/planets/galaxy map
        try {
            Image newStarImage = new Image(STARIMGPATH + starName + "/" + starName + ".png");
            setStarImage(newStarImage);
        }
        catch (Exception e) {
        }
        try {
            Image newGalaxyMapImage = new Image(GMAPIMGPATH + starName + "Map.png");
            setGalaxyMapImage(newGalaxyMapImage);
        }
        catch (Exception e) {
        }
        try {
            Image newStarImage1 = new Image(STARIMGPATH + starName + "/" + starName  +"1.png");
            setStarImage1(newStarImage1);
        }
        catch (Exception e) {
        }
        try {
            Image newStarImage2 = new Image(STARIMGPATH + starName + "/" + starName  +"2.png");
            setStarImage2(newStarImage2);
        }
        catch (Exception e) {
        }
        try {
            Image newStarImage3 = new Image(STARIMGPATH + starName + "/" + starName  +"3.png");
            setStarImage3(newStarImage3);
        }
        catch (Exception e) {
        }
        try {
            Image newStarImage4 = new Image(STARIMGPATH + starName + "/" + starName  +"4.png");
            setStarImage4(newStarImage4);
        }
        catch (Exception e) {
        }
    }
    
    //Star's detail setter
    //id number, Star's name, Neighbouring stars 1-4 as String names and as objects, Parent star(this star) and it's child planet's names and types.(if any). 
    public void setStarDetails( String n1, String n2, String n3, String n4, Star star1, Star star2, Star star3, Star star4, 
            Star parent, String planetName1, String planetType1, String planetName2, String planetType2, 
            String planetName3, String planetType3, String planetName4, String planetType4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
        
        //Creating the planets that orbit this star(star's children).
        //Star parent, String planet's name, String planet's type.
        Planet newPlanet1 = new Planet(parent, planetName1, planetType1, getStarImage1());
        this.planet1 = newPlanet1;
        
        Planet newPlanet2 = new Planet(parent, planetName2, planetType2, getStarImage2());
        this.planet2 = newPlanet2;
        
        Planet newPlanet3 = new Planet(parent, planetName3, planetType3, getStarImage3());
        this.planet3 = newPlanet3;
        
        Planet newPlanet4 = new Planet(parent, planetName4, planetType4, getStarImage4());
        this.planet4 = newPlanet4;
    }
    
    //Getters and setters........................................................
    public String getName() {
        return name;
    }

    public String getN1() {
        return n1;
    }

    public String getN2() {
        return n2;
    }

    public String getN3() {
        return n3;
    }

    public String getN4() {
        return n4;
    }

    public Star getStar1() {
        return star1;
    }

    public Star getStar2() {
        return star2;
    }

    public Star getStar3() {
        return star3;
    }

    public Star getStar4() {
        return star4;
    }

    public Image getStarImage() {
        return starImage;
    }

    public void setStarImage(Image starImage) {
        this.starImage = starImage;
    }

    public Image getStarImage1() {
        return starImage1;
    }

    public void setStarImage1(Image starImage1) {
        this.starImage1 = starImage1;
    }

    public Image getStarImage2() {
        return starImage2;
    }

    public void setStarImage2(Image starImage2) {
        this.starImage2 = starImage2;
    }

    public Image getStarImage3() {
        return starImage3;
    }

    public void setStarImage3(Image starImage3) {
        this.starImage3 = starImage3;
    }

    public Image getStarImage4() {
        return starImage4;
    }

    public void setStarImage4(Image starImage4) {
        this.starImage4 = starImage4;
    }
    
    public void setGalaxyMapImage(Image galaxyMapImage) {
        this.galaxyMapImage = galaxyMapImage;
    }

    public Image getGalaxyMapImage() {
        return galaxyMapImage;
    }

    public void setPlanet1(Planet planet1) {
        this.planet1 = planet1;
    }

    public Planet getPlanet1() {
        return planet1;
    }

    public Planet getPlanet2() {
        return planet2;
    }

    public void setPlanet2(Planet planet2) {
        this.planet2 = planet2;
    }

    public Planet getPlanet3() {
        return planet3;
    }

    public void setPlanet3(Planet planet3) {
        this.planet3 = planet3;
    }

    public Planet getPlanet4() {
        return planet4;
    }

    public void setPlanet4(Planet planet4) {
        this.planet4 = planet4;
    }

    public void setStarsSurface(Surface starsSurface) {
        this.starsSurface = starsSurface;
    }

    public Surface getStarsSurface() {
        return starsSurface;
    }

    public void setScoop(boolean scoop) {
        this.scoop = scoop;
    }
    public boolean getScoop() {
        return scoop;
    }

    public void setScoopTimes(int scoopTimes) {
        this.scoopTimes = scoopTimes;
    }

    public int getScoopTimes() {
        return scoopTimes;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }

    public boolean isScanned() {
        return scanned;
    }
    
}