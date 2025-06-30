package org.example.dto;

public class CustomerDTO {
    private String CID;
    private String CName;
    private String CAddress;

    public CustomerDTO(String CID, String CName, String CAddress) {
        this.CID = CID;
        this.CName = CName;
        this.CAddress = CAddress;
    }
    public CustomerDTO() {}

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCAddress() {
        return CAddress;
    }

    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "CID='" + CID + '\'' +
                ", CName='" + CName + '\'' +
                ", CAddress='" + CAddress + '\'' +
                '}';
    }
}
