package com.app.arjuntestkotlin.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "address")
public class EntityAddress {


    @PrimaryKey(autoGenerate = true)
    private int id;

    /*@ColumnInfo(name = "created_date")
    @TypeConverters(Converters.class)
    private Date created_date;
*/

    EntityAddress()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "from_date")
    private String description;

    @ColumnInfo(name = "to_date")
    private String colorcode;

    @ColumnInfo(name = "coupon_code")
    private String coupon_code;

    public EntityAddress(String id, String name, String description, String colorcode, String coupon_code) {

        this.name = name;
        this.description = description;
        this.colorcode = colorcode;
        this.coupon_code = coupon_code;
    }
}