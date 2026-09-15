// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  private TalonFX intakeMotor;
  private TalonFXConfiguration intakeConfig;

  private MotionMagicVoltage m_motionRequest;

  private IntakeStates currentState = IntakeStates.STOP;


  public Intake() {
  
  //intakeMotor = new TalonFX(IntakeConstants.kIntakeMotorId);

  // intakeConfig = new TalonFXConfiguration()
  //                     .withMotorOutput(new MotorOutputConfigs()
  //                                           .withInverted(InvertedValue.Clockwise_Positive)
  //                                           .withNeutralMode(NeutralModeValue.Brake))     
    //                  .withCurrentLimits( new currentlimitsconfig())
    //                                        .withSupplyCurrentLimit(IntakeConstants.kIntakeSupplyCurrentLimit());
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
