package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingTrip  {

    /**
     * 会议城市，会议管控必传
     * 
     */
    @JsonProperty("meeting_city")
    private List<BusinessCity> meetingCity;
}

