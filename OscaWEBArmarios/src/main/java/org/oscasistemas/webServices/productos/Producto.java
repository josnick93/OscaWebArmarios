package org.oscasistemas.webServices.productos;

/**
 * Representación de un producto
 * @author Jose Angel Caudevilla
 *
 */
public class Producto {
    private String Key;
    private String No;
    private String Description;
    private double Inventory;
    private String Search_Description;


    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getInventory() {
        return Inventory;
    }

    public void setInventory(double inventory) {
        Inventory = inventory;
    }

    public String getSearch_Description() {
        return Search_Description;
    }

    public void setSearch_Description(String search_Description) {
        Search_Description = search_Description;
    }
}
