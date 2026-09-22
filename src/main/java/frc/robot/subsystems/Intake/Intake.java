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
  
  private TalonFX pivotMotor;
  private TalonFXConfiguration pivotConfig; 

  private MotionMagicVoltage m_motionRequest;

  private IntakeStates currentState = IntakeStates.STOP;
  private IntakePivotState currentPivotState = IntakePivotState.STOP;


  public Intake() {
  
    intakeMotor = new TalonFX(IntakeConstants.kIntakeMotorId);

    intakeConfig = new TalonFXConfiguration()
                       .withMotorOutput(new MotorOutputConfigs()
                                             .withInverted(InvertedValue.Clockwise_Positive)
                                             .withNeutralMode(NeutralModeValue.Brake))     
                       .withCurrentLimits(new CurrentLimitsConfigs()
                                             .withSupplyCurrentLimit(IntakeConstants.kIntakeSupplyCurrentLimit));
    intakeMotor.getConfigurator().apply(intakeConfig);


    pivotMotor = new TalonFX(IntakeConstants.kPivotMotorId);
    pivotConfig = new TalonFXConfiguration()
                      .withMotorOutput(new MotorOutputConfigs()
                                              .withInverted(InvertedValue.Clockwise_Positive)
                                              .withNeutralMode(NeutralModeValue.Brake))
                        .withCurrentLimits(new CurrentLimitsConfigs()
                                              .withSupplyCurrentLimit(IntakeConstants.kIntakeSupplyCurrentLimit));
    pivotMotor.getConfigurator().apply(pivotConfig);
  }
  

  public void setGoal(IntakeStates desiredState) {
    currentState = desiredState;
    switch(desiredState){
      case INTAKE :
        intakeMotor.set(IntakeConstants.kSpeed);
        break;
      case OUTTAKE :
        intakeMotor.set(-IntakeConstants.kSpeed);
        break;
      case STOP :
        intakeMotor.stopMotor();
        break;
    }
  }

  public void setPivotGoal(IntakePivotState desiredState) {
    currentPivotState = desiredState;
    switch(desiredState){
      case PIVOT_UP :
        pivotMotor.set(IntakeConstants.kPivotSpeed);
        break;
      case PIVOT_DOWN :
        pivotMotor.set(-IntakeConstants.kPivotSpeed);
        break;
      case STOP :
        pivotMotor.stopMotor();
        break;
    }
  }

//GRAAAAAAAAAAAAAAAHHHHHHHHHHHHH bruh
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
