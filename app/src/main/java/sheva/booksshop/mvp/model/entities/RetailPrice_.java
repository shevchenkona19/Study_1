
package sheva.booksshop.mvp.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetailPrice_ {

    @SerializedName("amountInMicros")
    @Expose
    private Integer amountInMicros;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RetailPrice_() {
    }

    /**
     * 
     * @param amountInMicros
     * @param currencyCode
     */
    public RetailPrice_(Integer amountInMicros, String currencyCode) {
        super();
        this.amountInMicros = amountInMicros;
        this.currencyCode = currencyCode;
    }

    public Integer getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(Integer amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
