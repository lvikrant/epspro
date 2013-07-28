package com.test.backup;

public class GameSensorEvents
{
	double sensor_id;
	double timestamp;
	double position_x;
	double position_y;
	double position_z;
	double direction_vector;
	double acceleration_vector;
	double direction_x;
	double direction_y;
	double direction_z;
	double acceleration_x;
	double acceleration_y;
	double acceleration_z;


	public GameSensorEvents(double sensor_id, double timestamp, double position_x,
			double position_y, double position_z, double direction_vector,
			double acceleration_vector, double direction_x, double direction_y,
			double direction_z, double acceleration_x, double acceleration_y,
			double acceleration_z) {
	
		this.sensor_id = sensor_id;
		this.timestamp = timestamp;
		this.position_x = position_x;
		this.position_y = position_y;
		this.position_z = position_z;
		this.direction_vector = direction_vector;
		this.acceleration_vector = acceleration_vector;
		this.direction_x = direction_x;
		this.direction_y = direction_y;
		this.direction_z = direction_z;
		this.acceleration_x = acceleration_x;
		this.acceleration_y = acceleration_y;
		this.acceleration_z = acceleration_z;
	}
	
	public double getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(double sensor_id) {
		this.sensor_id = sensor_id;
	}
	public double getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	}
	public double getPosition_x() {
		return position_x;
	}
	public void setPosition_x(double position_x) {
		this.position_x = position_x;
	}
	public double getPosition_y() {
		return position_y;
	}
	public void setPosition_y(double position_y) {
		this.position_y = position_y;
	}
	public double getPosition_z() {
		return position_z;
	}
	public void setPosition_z(double position_z) {
		this.position_z = position_z;
	}
	public double getDirection_vector() {
		return direction_vector;
	}
	public void setDirection_vector(double direction_vector) {
		this.direction_vector = direction_vector;
	}
	public double getAcceleration_vector() {
		return acceleration_vector;
	}
	public void setAcceleration_vector(double acceleration_vector) {
		this.acceleration_vector = acceleration_vector;
	}
	public double getDirection_x() {
		return direction_x;
	}
	public void setDirection_x(double direction_x) {
		this.direction_x = direction_x;
	}
	public double getDirection_y() {
		return direction_y;
	}
	public void setDirection_y(double direction_y) {
		this.direction_y = direction_y;
	}
	public double getDirection_z() {
		return direction_z;
	}
	public void setDirection_z(double direction_z) {
		this.direction_z = direction_z;
	}
	public double getAcceleration_x() {
		return acceleration_x;
	}
	public void setAcceleration_x(double acceleration_x) {
		this.acceleration_x = acceleration_x;
	}
	public double getAcceleration_y() {
		return acceleration_y;
	}
	public void setAcceleration_y(double acceleration_y) {
		this.acceleration_y = acceleration_y;
	}
	public double getAcceleration_z() {
		return acceleration_z;
	}
	public void setAcceleration_z(double acceleration_z) {
		this.acceleration_z = acceleration_z;
	}

	@Override
	public String toString() {

		return  "Sensor_Id: " + String.valueOf(sensor_id) + 
				" Timestamp: " + String.valueOf(timestamp) +
				" Position_X: "+ String.valueOf(position_x)+
				" Position_Y: "+ String.valueOf(position_y)+
				" Position_Z: "+ String.valueOf(position_z)+
				" Direction_Vector: "+String.valueOf(direction_vector)+
				" Accelerationv_ector: "+String.valueOf(acceleration_vector)+
				" Direction_X "+String.valueOf(direction_x)+
				" Direction_Y: "+String.valueOf(direction_y)+
				" Direction_Z: "+String.valueOf(direction_z)+
				" Acceleration_X: "+String.valueOf(acceleration_x)+
				" Acceleration_Y: "+String.valueOf(acceleration_y)+
				" Acceleration_Z: "+String.valueOf(acceleration_z);
	}
}
