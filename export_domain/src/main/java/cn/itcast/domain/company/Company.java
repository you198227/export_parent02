package cn.itcast.domain.company;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Company implements Serializable {

    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate; // expiration_date
    private String address;
    private String licenseId;   //license_id
    private String representative;
    private String phone;
    private String companySize; //company_size
    private String industry;
    private String remarks;
    private Integer state;
    private Double balance;
    private String city;

}
