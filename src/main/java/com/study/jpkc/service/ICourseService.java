package com.study.jpkc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.jpkc.entity.Course;
import com.study.jpkc.shiro.AccountProfile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isharlan.hu@gmail.com
 * @since 2020-12-18
 */
public interface ICourseService extends IService<Course> {

    /**
     * 搜索所有课程
     * @return 所有课程
     */
    List<Course> selectAllCourse();

    /**
     * 通过用户id查询订阅课程
     * @param userId 用户id
     * @return 订阅课程
     */
    List<Course> findCourseByUserId(String userId);


    /**
     * 获取每周热门排行课程
     * @param current 当前页
     * @param size 每页条数
     * @return list
     */
    List<Course> getRanking(Integer current, Integer size);


    /**
     * 获取每周最新课程排行
     * @param current 当前页
     * @param size 每页条数
     * @return list
     */
    List<Course> getNew(Integer current, Integer size);


    /**
     * 获取每周收场最多排行
     * @param current 当前页
     * @param size 每页条数
     * @return list
     */
    List<Course> getStar(Integer current, Integer size);

    /**
     * 通过标签id获取课程信息
     * @param labelId 标签id
     * @param current 当前页
     * @param size 每页条数
     * @return 课程信息
     */
    Page<Course> getByLabelId(String labelId, Integer current, Integer size);

    /**
     * 通过分类id获取课程信息
     * @param categoryId 分类id
     * @param current 当前页
     * @param size 每页大小
     * @return 课程信息
     */
    Page<Course> getByCategoryId(String categoryId, Integer current, Integer size);

    /**
     * 创建课程
     * @param accountProfile 用户
     * @param course 课程实体
     * @param multipartFile logo文件
     * @param categoryId 类别id
     * @param labelNames 标签
     * @throws IOException 异常
     * @return 成功返回courseId 失败返回null
     */
    String save(AccountProfile accountProfile, Course course, MultipartFile multipartFile, String categoryId, String[] labelNames) throws IOException;

    /**
     * 上传课程logo
     * @param courseId 课程id
     * @param logoFile logo文件
     * @throws IOException 异常
     * @return 文件资源地址
     */
    Boolean uploadLogo(String courseId, MultipartFile logoFile) throws IOException;
}
