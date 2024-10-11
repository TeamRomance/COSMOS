import React from "react";
import "../../assets/styles/main-page.css";
import LeftSideNavigation from "../../components/LeftSideNavigation";

import arrow_left from "../../assets/images/mainPage's/arrow-left.png"
import arrow_right from "../../assets/images/mainPage's/arrow-right.png"

import award1 from "../../assets/images/mainPage's/2023-award-grand.png"
import award2 from "../../assets/images/mainPage's/2023-award-runnerup.png"
import award3 from "../../assets/images/mainPage's/2023-award-bronze.png"
import copyright from "../../assets/images/mainPage's/2023-copyright.png"
import journal from "../../assets/images/mainPage's/2024-journal.png"

import egg from "../../assets/images/mainPage's/easter_egg.png"
import team_photo from "../../assets/images/mainPage's/team_photo.png"

import maythe4th from "../../assets/images/mainPage's/portfolio/포트폴리오용 메이더포스.gif"

export default function MainPage() {



    return (
        <div>
        <div className="main-container">

            <div className="main-vertical-left">
                <img
                    className="arrow_left"
                    src={arrow_left}
                    alt="arrow_left"
                />
                <LeftSideNavigation/>
            </div>

            <div className="main-vertical-center">
            <p className="project-title">{
                `PROJECT COSMOS`
            }</p>
                <div className="center-top">
                    <p className="team">{
                        `Team.`
                    }</p>
                    <div className="center-top-images">
                        <img
                            className="award1"
                            src={award1}
                            alt="award1"
                        />
                        <img
                            className="award2"
                            src={award2}
                            alt="award2"
                        />
                        <img
                            className="award3"
                            src={award3}
                            alt="award3"
                        />
                        <img
                            className="copyright"
                            src={copyright}
                            alt="copyright"
                        />
                        <img
                            className="journal"
                            src={journal}
                            alt="journal"
                        />
                    </div>

                </div>
                <p className="site_purpose">{
                    `Romance's Portfolio`
                }</p>
                <div className="center-center">
                    <img
                        className="egg"
                        src={egg}
                        alt="egg"
                    />
                    <img
                        className="team_photo"
                        src={team_photo}
                        alt="team_photo"
                    />
                </div>
                <box className="center-bottom-top">
                    <p className="site_humor">{
                        `꽁꽁 얼어붙은 취업시장 위로 
        낭만이 걸어다닙니다.`
                    }</p>
                </box>
                <div className="center-bottom">

                </div>
            </div>

            <div className="main-vertical-right">
                <img
                    className="arrow_right"
                    src={arrow_right}
                    alt="arrow_right"
                />
            </div>
        </div>

        </div>
    );
}
