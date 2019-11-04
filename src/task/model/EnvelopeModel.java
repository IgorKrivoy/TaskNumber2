package task.model;


public class EnvelopeModel {

    private float width, height;
    private float diagonal;

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public EnvelopeModel(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        EnvelopeModel envelope = (EnvelopeModel) obj;
        return envelope.width < this.width && envelope.height < this.height;
    }


}
