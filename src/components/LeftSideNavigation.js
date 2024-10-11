import React from "react";
import Icon from "./Icon";
import '../assets/styles/nav-bar.css'


function LeftSideNavigation() {
    // 아이콘 개수 설정
    const numberOfIcons = 5;

    // 아이콘 컴포넌트 배열 생성
    const icons = Array.from({length: numberOfIcons}, (_, index) =>(
        <Icon key={index} index={index + 1} />
    ));

    return(
        <nav className="nav-bar">
            {icons}
        </nav>
    )
}

export default LeftSideNavigation;
