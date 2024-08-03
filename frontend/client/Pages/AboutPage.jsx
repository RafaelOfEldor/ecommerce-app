import React from "react";
import { FaLinkedin, FaGithub, FaGoogle, FaMicrosoft   } from "react-icons/fa";
import "./css/pages/aboutPage.css";

export default function AboutPage(props) {
  return (
    <div className="about-container">
      <div className="about-header">
        {/* <img src={Logo} alt="Project Logo" className="project-logo" /> */}
        {/* <h1>About This Project</h1> */}
      </div>
      <div className="about-content">
        <div className="about-info">
          <h2>Project Overview</h2>
          <p>
            Welcome to my mock ecommerce project! This app is all about pretending
            to be rich and buying as much as you want of whatever you want.
            Register or sign in, add a fake address to your account and go ham. Today you are rich
            and anything you'd ever want is waiting to be bought by you! However, there is a limited
            stock for each item so you'd better get those hands movin'!
          </p>
          <p>
            Feel free to browse the code and
            provide feedback.
          </p>
        </div>
        <div className="about-image">
          <div className="about-image-content">
            <img src="https://via.placeholder.com/300" alt="Project Showcase" />
            <div className="additional-info">
              <h3>Why did i create this project?</h3>
              <p>
                I created this project
                mainly to improve my ability to use Spring Boot as a backend.
                As i run the backend and frontend separately, i figured it
                would also provide an oportunity for me to learn docker and container
                orchestration, which then led to me choosing AWS as my deployment
                platform. This project features user authentication with JWT and google OAUTH2, a decently sized backend-API,
                product browsing, and a fully functional {"(fake)"} shopping cart amongst other things. It heavily depends on
                the right relations in the database between addresses, orders, users and reviews
                which i managed through the ORM technique. As for my deployment,
                I run three separate containers, frontend, backend and database.
                I launch these three containers as services in an AWS ECS cluster, and use an ALB on the "mock-ecommerce.com" domain
                to correctly navigate traffic between client and api.

                {/* This project is a demonstration of how to integrate various
                technologies and create a seamless user experience. It's a great
                starting point for anyone looking to learn about full-stack web
                development. */}
              </p>
              <h3>Technologies Used</h3>
              <ul>
                <li>React</li>
                <li>Node.js</li>
                <li>Spring Boot</li>
                <li>Express</li>
                <li>PostgreSQL</li>
                <li>Docker</li>
                <li>AWS</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div className="about-links">
        <h2>Connect with Me</h2>
        <div className="profile-links">
          <a href="https://www.linkedin.com/in/audun-alhassan/" target="_blank" rel="noopener noreferrer">
            <FaLinkedin style={{color: "cyan"}}/> LinkedIn
          </a>
          <a href="https://github.com/RafaelOfEldor" target="_blank" rel="noopener noreferrer">
            <FaGithub style={{color: "black"}}/> GitHub
          </a>
        </div>
      </div>
    </div>
  );
}
