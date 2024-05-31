package net.onione.data.mapper.hc;

import net.onione.model.dto.AllMemberOutDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<AllMemberOutDto> getAllMember();

}
