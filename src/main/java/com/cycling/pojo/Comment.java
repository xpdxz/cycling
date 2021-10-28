package com.cycling.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: Comment
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/22 6:13 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    /**
     * 评论id
     */
    private Integer id;

    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 用户id
     */
    private Integer userId;
}