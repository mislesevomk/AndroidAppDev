/*
Jacob Muzikoski
z1756867
Assignment 1
Basketball Calculator

Background Image:
https://image.winudf.com/39/2f0d59ece99d56/screen-1.jpg

This app allows the user to input the number of shots made in the form of two pointer's and
three pointer's. It also asks the user to input the amount of rebounds for a single game.
The user then hits submit and the the App displays the average shots made and average shots rebounded.
The app also displays the amount of attempted shots, total points, and shots made during that game.
 */

package mislesevomk.basketballaverageshotcalculator;

public class PlayerShots
{
    // Type of shots a player can make
    static final Double twoPointers = 2.0;
    static final Double threePointers = 3.0;

    private Double twoPointersMade;
    private Double threePointersMade;
    private Double shotsMade;
    private Double shotsRebound;
    private Double shotsMadeAVG;
    private Double shotsReboundAVG;
    private Double shotsTotal;
    private Double pointsTotal;
    private Double shotsMadeTotal;

    PlayerShots()
    {
        twoPointersMade = 0.0;
        threePointersMade = 0.0;
        shotsMade = 0.0;
        shotsRebound = 0.0;
        shotsTotal = 0.0;
        pointsTotal = 0.0;
        shotsMadeTotal = 0.0;
        shotsMadeAVG = 0.0;
        shotsReboundAVG = 0.0;
    }

    public Double getTwoPointersMade()
    {
        return twoPointersMade;
    }

    public void setTwoPointersMade(Double twoPointersMade) { this.twoPointersMade = twoPointersMade; }

    public Double getThreePointersMade()
    {
        return threePointersMade;
    }

    public void setThreePointersMade(Double threePointersMade) { this.threePointersMade = threePointersMade; }

    public Double getShotsMade() { return shotsMade; }

    public void setShotsMade(Double shotsMade) { this.shotsMade = shotsMade; }

    public Double getShotsRebound() { return shotsRebound; }

    public void setShotsRebound(Double shotsRebound)
    {
        this.shotsRebound = shotsRebound;
    }

    // Calls the compute average method to get the results from user input
    public Double getShotsMadeAVG()
    {
        computeAVGMade();
        return shotsMadeAVG;
    }

    public void setShotsMadeAVG(Double shotsMadeAVG)
    {
        this.shotsMadeAVG = shotsMadeAVG;
    }

    public Double getShotsReboundAVG()
    {
        computeAVGRebound();
        return shotsReboundAVG;
    }

    public void setShotsReboundAVG(Double shotsReboundAVG) { this.shotsReboundAVG = shotsReboundAVG; }

    public Double getShotsTotal()
    {
        return shotsTotal;
    }

    public void setShotsTotal(Double shotsTotal)
    {
        this.shotsTotal = shotsTotal;
    }

    public Double getPointsTotal()
    {
        return pointsTotal;
    }

    public void setPointsTotal(Double pointsTotal)
    {
        this.pointsTotal = pointsTotal;
    }

    public Double getShotsMadeTotal() {
        return shotsMadeTotal;
    }

    public void setShotsMadeTotal(Double shotsMadeTotal) {
        this.shotsMadeTotal = shotsMadeTotal;
    }

    private void computeAVGMade()
    {
        // Multiples the user's input for number of two and three pointers by the value of a two pointer and three pointer's value
        pointsTotal = (twoPointers * twoPointersMade) + (threePointers * threePointersMade);

        // Total of all two and three pointers made
        shotsMade = twoPointersMade + threePointersMade;

        // Total of all shots attempted
        shotsTotal = shotsMade + shotsRebound;

        // Divides shots made by the total to figure out the average shots made during the game
        shotsMadeAVG = shotsMade / shotsTotal;

        shotsMadeTotal = shotsMade;
    }

    private void computeAVGRebound()
    {
        // Total of all shots attempted
        shotsTotal = shotsMade + shotsRebound;

        // Divides rebounds by the total to figure out the average rebounds made during the game
        shotsReboundAVG = shotsRebound / shotsTotal;
    }
}


