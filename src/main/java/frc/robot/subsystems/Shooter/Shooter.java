// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  TalonFX shooterMotor;
  TalonFXConfiguration shooterConfig;

  MotionMagicVoltage m_motionRequest;

  private ShooterState currentState = ShooterState.STOP;

  public Shooter() {

  shooterMotor = new TalonFX(ShooterConstants.kShooterMotorId);
  shooterConfig = new TalonFXConfiguration()
                    .withMotorOutput(new MotorOutputConfigs()
                                        .withInverted(InvertedValue.Clockwise_Positive)
                                        .withNeutralMode(NeutralModeValue.Brake))
                    .withCurrentLimits(new CurrentLimitsConfigs()
                                        .withSupplyCurrentLimit(ShooterConstants.kShooterCurrentLimit));
  shooterMotor.getConfigurator().apply(shooterConfig);
    

  }

  public void setGoal(ShooterState desiredState) {
    currentState = desiredState;
    switch(desiredState){
      case SHOOT : 
        shooterMotor.set(ShooterConstants.kSpeed);
        break;
      case STOP :
        shooterMotor.set(ShooterConstants.kSpeed);
        break;

    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
