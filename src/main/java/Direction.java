/* Created By Oussama MOSSATI -- On October the 10th 2022 */

public enum Direction {
    //Each direction has a step size to apply on X and Y
    //Each direction has the overridden abstract methods left() and right() to determine the new direction after making a turn
    N(0, 1){
        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }
    },
    E(1, 0){
        @Override
        public Direction left() { return N; }

        @Override
        public Direction right() { return S; }
    },
    W(-1, 0){
        @Override
        public Direction left() { return S; }

        @Override
        public Direction right() { return N; }
    },
    S(0, -1){
        @Override
        public Direction left() { return E; }

        @Override
        public Direction right() { return W; }
    };

    private final int stepSizeX;
    private final int stepSizeY;

    Direction(int stepSizeX, int stepSizeY){
        this.stepSizeX = stepSizeX;
        this.stepSizeY = stepSizeY;
    }

    public int getStepSizeX(){
        return this.stepSizeX;
    }
    public int getStepSizeY(){
        return this.stepSizeY;
    }

    public abstract Direction left();
    public abstract Direction right();
}
