package coreservlets;


public class ColorBean {
    private String foreground = "black";

    private String background = "white";

    public ColorBean() {
    }
    
    public String getForeground() {
        return foreground;
    }

    public void setForeground(String foregroundColor) {
        this.foreground = foregroundColor;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String backgroundColor) {
        this.background = backgroundColor;
    }
    
    
}
