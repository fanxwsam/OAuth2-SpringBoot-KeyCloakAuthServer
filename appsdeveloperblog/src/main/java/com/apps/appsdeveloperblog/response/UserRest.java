package com.apps.appsdeveloperblog.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class UserRest {
     String firstName;
     String lastName;
     String userId;
}
