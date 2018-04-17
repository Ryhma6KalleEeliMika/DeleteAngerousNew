/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mika Vuorinen
 */
public class Hull {
    private int hull;
    private int maxHull;
    private String name;
    
    
    Hull(int newMaxHull, String newName){
        setHull(newMaxHull);
        setMaxHull(newMaxHull);
        setName(newName);
    }
    
    //Hull loss method
    public void hullLoss(int hullLoss){
        setHull(hull - hullLoss);
    }
    
    //Hull gain method "Not used yet."
    public void hullGain(int hullGain){
        if(hullGain + getHull() >= getMaxHull()){
            setHull(getMaxHull());
        }
        else{
            setHull(getHull() + hullGain);
        }
        
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getMaxHull() {
        return maxHull;
    }

    public void setMaxHull(int maxHull) {
        this.maxHull = maxHull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
