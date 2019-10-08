package task;


public class Envelope {

    private float width,height;
    private float diagonal;

    float getDiagonal(){ return diagonal; }

    float getWidth(){
        return width;
    }

    float getHeight(){
        return height;
    }

    public Envelope(float width, float height){
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        Envelope envelope = (Envelope)obj;
        return envelope.width < this.width && envelope.height < this.height;
    }


    private void findDiagonal(){

        this.diagonal = (float)(Math.pow(this.width,2) + Math.pow(this.height,2));
    }

}
