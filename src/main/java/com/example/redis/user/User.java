package com.example.redis.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@RedisHash("User")
public class User {
    @Id
    private String id;
    private String name;
    private Long salary;
}
