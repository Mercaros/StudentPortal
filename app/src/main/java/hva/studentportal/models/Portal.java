package hva.studentportal.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by khaled on 06-10-18.
 */

public class Portal implements Parcelable {
    private String urlLink;
    private String titleName;

    public Portal(String urlLink, String titleName) {
        this.urlLink = urlLink;
        this.titleName = titleName;
    }

    protected Portal(Parcel in) {
        urlLink = in.readString();
        titleName = in.readString();
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlLink);
        dest.writeString(titleName);
    }

    public static final Creator<Portal> CREATOR = new Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel in) {
            return new Portal(in);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };

    @Override
    public String toString() {
        return "Portal{" +
                "urlLink='" + urlLink + '\'' +
                ", titleName='" + titleName + '\'' +
                '}';
    }

}
