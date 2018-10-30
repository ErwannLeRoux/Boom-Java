public interface FighterStrategy 
{
    /**
     * Methode qui va permettre de choisir l'action a effectuer suivant une certaine stratégie
     * @return 
     *  Retourne l'action que le combattant doit realiser
     */
    public Actions doAction();
    //public Actions doAction(ArrayList<Elements> objs, ArrayList<Explosives> stuff, int shotNumber);
}