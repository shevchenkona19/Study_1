package sheva.intentactions;

import android.os.Parcel;
import android.os.Parcelable;

public class UserEntity implements Parcelable{
    private String name;
    private String telephone;
    private String city;
    private String country;

    public UserEntity(String name, String telephone, String city, String country) {
        this.name = name;
        this.telephone = telephone;
        this.city = city;
        this.country = country;
    }

    protected UserEntity(Parcel in) {
        name = in.readString();
        telephone = in.readString();
        city = in.readString();
        country = in.readString();
    }

    public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel in) {
            return new UserEntity(in);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(telephone);
        parcel.writeString(city);
        parcel.writeString(country);
    }
}
