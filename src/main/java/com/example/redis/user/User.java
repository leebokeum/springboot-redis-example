package com.example.redis.user;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@RedisHash("User")
public class User implements Serializable {
    private static final long serialVersionUID = 1370692830319429806L;
    @Id
    private String id;
    private String name;
    private Long salary;
}
