package com.ieps.mapper;

import com.ieps.dto.UserAdminDto;
import com.ieps.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    
    
    UserInfo selectByUserNum(String userNum);
    
    int updateByUserNumSelective(UserInfo userInfo);
    
    int selectByUserNumAndEmail(@Param("userNum") String userNum, @Param("email") String email);
    
    int selectByUserNumAndPhotoNum(@Param("userNum") String userNum, @Param("photoNum") String photoNum);
    
    int updateSexByUserNum(@Param("userNum") String userNum, @Param("sex")Integer sex);
    
    
    int deleteByUserNum(String userNum);
    
    int deleteUserInfoByUserNum(String[] userNums);
    
    UserInfo selectUserInfoByUserName(String userName);

    @Select(" SELECT iui.id  AS id, iui.user_num AS userNum, iui.user_name AS userName, iui.user_img AS userImg, iui.photo_num AS photoNum, iui.email AS email,\n" +
            " iui.title AS title, iui.sex AS sex, iui.academy AS academy, iui.grade AS grade, iui.major AS major, iui.birth_date AS birthDate\n" +
            " FROM ieps_user_info iui where iui.academy = #{academy}" +
            "AND EXISTS(SELECT * FROM ieps_user_role  r where r.user_num=iui.user_num AND r.role_id in (200003,200005) )")
    List<UserInfo> selectUserInfoByAcademy(String academy);
    
    List<UserInfo> selectUserInfoLikeUserName(@Param("userNum") String userNum, @Param("userName") String userName);
    
    
    //  通过项目编号 查看项目详情  项目负责人 组员 指导老师
    List<UserAdminDto> selectUserInfoWithItemNum(String itemNum);
    
    
    // 展示控制管理
    // List<UserAdminDto> selectStuUserInfoWithAcademy(String userNum);
    
    
    
    
}