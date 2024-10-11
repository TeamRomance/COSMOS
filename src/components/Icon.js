import React from 'react';
import '../assets/styles/icon.css'

import icon1 from '../assets/images/xNavigationIconsx/icon1.PNG';
import icon1Hover from '../assets/images/xNavigationIconsx/icon1-hover.PNG';
import icon2 from '../assets/images/xNavigationIconsx/icon2.PNG';
import icon2Hover from '../assets/images/xNavigationIconsx/icon2-hover.PNG';
import icon3 from '../assets/images/xNavigationIconsx/icon3.PNG';
import icon3Hover from '../assets/images/xNavigationIconsx/icon3-hover.PNG';
import icon4 from '../assets/images/xNavigationIconsx/icon4.PNG';
import icon4Hover from '../assets/images/xNavigationIconsx/icon4-hover.PNG';
import icon5 from '../assets/images/xNavigationIconsx/icon5.PNG';
import icon5Hover from '../assets/images/xNavigationIconsx/icon5-hover.PNG';

// 각 아이콘의 이미지를 객체로 맵핑
const images = {
    1: { default: icon1, hover: icon1Hover },
    2: { default: icon2, hover: icon2Hover },
    3: { default: icon3, hover: icon3Hover },
    4: { default: icon4, hover: icon4Hover },
    5: { default: icon5, hover: icon5Hover },
};

const Icon = ({ index }) => {
    return (
        <img
            src={images[index].default}    // 기본 이미지 경로 설정
            alt={`icon${index}`}           // alt 속성 설정
            className="icon"               // 클래스 이름 설정
            onMouseOver={e => e.currentTarget.src = images[index].hover}   // hover 시 이미지 변경
            onMouseOut={e => e.currentTarget.src = images[index].default}  // hover 해제 시 원래 이미지로 복구
        />
    );
};

export default Icon;
