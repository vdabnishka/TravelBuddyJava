SELECT _id,
	name,
	description,
	city,
	province,
	country,
	startDate,
	endDate
FROM Trips
WHERE _id = ?