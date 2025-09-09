package com.report.request;




import lombok.Data;

@Data
public class SearchRequest {
    
    private String planName;
    private String planStatus;
    private String gender;
//    @DateTimeFormat(pattern =" dd-mm-yyyy")
//    private LocalDate startDate;
//    @DateTimeFormat(pattern =" dd-mm-yyyy")
//    private LocalDate endDate;
    
    private String startDate;
    private String endDate;


}
