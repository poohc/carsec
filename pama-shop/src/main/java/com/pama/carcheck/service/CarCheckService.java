package com.pama.carcheck.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.carcheck.dao.CarCheckDAO;
import com.pama.carcheck.vo.CarCheckQuestionVO;
import com.pama.carcheck.vo.CarCheckVO;

@Service
public class CarCheckService {

	private static final Log LOG = LogFactory.getLog(CarCheckService.class);

	@Autowired
	private CarCheckDAO carCheckDAO;

	public List<CarCheckVO> getCarCheckFirstList() {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'getCarCheckFirstList' method...");
		}
		return carCheckDAO.getCarCheckFirstList();
	}

	public CarCheckQuestionVO getCarCheckNextList(CarCheckVO carCheckVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'getCarCheckNextList' method...");
		}

		//검증
		List<CarCheckVO> nextList = carCheckDAO.getCarCheckNextList(carCheckVO);
		int nextListSize = nextList.size();

		CarCheckVO nextCarCheckVO = new CarCheckVO();

		CarCheckQuestionVO carCheckQuestionVO = new CarCheckQuestionVO();
		if(nextListSize == 1){ // 답변 한개 있을경우
			nextCarCheckVO = nextList.get(0);

			if(StringUtils.equals(nextCarCheckVO.getGcodeType(),"Q")){//질문
				carCheckQuestionVO.setQuestionType("Q");
				carCheckQuestionVO.setTotalCount(carCheckDAO.getCarCheckGcodeTotalCount(nextCarCheckVO));
				carCheckQuestionVO.setCarCheckVO(carCheckDAO.getCarCheckOne(nextCarCheckVO));
				carCheckQuestionVO.setList(carCheckDAO.getCarCheckNextList(nextCarCheckVO));
			}else if(StringUtils.equals(nextCarCheckVO.getGcodeType(),"F")){//최종답변
				carCheckQuestionVO.setQuestionType("F");
				carCheckQuestionVO.setTotalCount(carCheckDAO.getCarCheckGcodeTotalCount(carCheckVO));
				carCheckQuestionVO.setCarCheckVO(nextCarCheckVO);
				carCheckQuestionVO.setList(nextList);
			}else{//특수한 경우 문제사임 Exception
				carCheckQuestionVO.setQuestionType("ERROR");
			}

		} else if(nextListSize > 1) {//답변이 A B C일경우에 여러개 일경우에
			carCheckQuestionVO.setQuestionType("S");
			carCheckQuestionVO.setTotalCount(carCheckDAO.getCarCheckGcodeTotalCount(carCheckVO));
			carCheckQuestionVO.setCarCheckVO(carCheckDAO.getCarCheckOne(carCheckVO));
			carCheckQuestionVO.setList(nextList);

		}else{ //그외 경우는 없어야함Exception
			carCheckQuestionVO.setQuestionType("ERROR");
		}

		return carCheckQuestionVO;
	}

}
